import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { FaEyeSlash } from "react-icons/fa";
import { FaEye } from "react-icons/fa";
import TextError from "../../TextError";
import "bootstrap/dist/css/bootstrap.min.css";
import * as yup from "yup";
import { useAuth } from "../../auth";
import Input from "../../input";
import loginService from "../Services/loginService";
import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import "bootstrap-icons/font/bootstrap-icons.css";
import 'font-awesome/css/font-awesome.min.css';
const LoginForm = () => {
    let navigate = useNavigate();
    const auth = useAuth();
    const [passwordtype, setpasswordtype] = useState("password");
    const [visible, setvisible] = useState(false);
    const lowercaseRegex = /(?=.*[a-z])/;
    const uppercaseRegex = /(?=.*[A-Z])/;
    const numericRegex = /(?=.*[0-9])/;
    const specialcharactersRegex = /(?=.[@#$%!&^&-+=()])/;
    const handleclick = () => {
        if (visible) {
            setpasswordtype("password");
        } else {
            setpasswordtype("text");
        }
        setvisible((prevState) => !prevState);
    };
    const initialValues = {
        username: "",
        password: ""
    };
    const onSubmit = (values, onSubmitProps) => {

        loginService.check(values).then((res) => {
            console.log(res);
                localStorage.setItem('id_token', res.data);
                alert("Login Successful");
                onSubmitProps.setSubmitting(false);
                onSubmitProps.resetForm();
                loginService.getDetailByusername(values.username).then((res1) => {
                    const id = res1.data.id;
                    const userName = res1.data.username;
                    const userEmailId = res1.data.email;
                    const userRole = res1.data.userRole;
                    auth.login(id, userName, userEmailId, userRole);
                    if (res1.data.userRole === "Admin") {
                        let path = `/admin`;
                        navigate(path);
                    } else {
                        let path = "/customer";
                        navigate(path);
                    }
                });
        }).catch(err=>{
            alert("Invalid Credentials");
            onSubmitProps.setSubmitting(false);
            onSubmitProps.resetForm();
        });
    };
    const validationSchema = yup.object({
        username: yup.string().required("username is required"),
        password: yup
            .string()
            .matches(lowercaseRegex, "atleast one lowercase required!")
            .matches(uppercaseRegex, "atleast one uppercase required!")
            .matches(numericRegex, "atleast one number required!")
            .matches(
                specialcharactersRegex,
                "must contain atleast one character from {@#$%!*&^&-+=()}"
            )
            .min(8, "Must contain atleast 8 characters")
            .required("Password is required")
    });
    return (
        <>
            <Formik
                initialValues={initialValues}
                onSubmit={onSubmit}
                validationSchema={validationSchema}
            >
                {(formik) => (
                    <Form className="container border border-secondary" id="bgformcolor">
                        <Input name="username" label="Username" type="username" symbol={formik} id="space"/>

                        <div className="col-12 mb-2 mt-2">
                            <label htmlFor="password">Password</label>
                            <div clasName="row">
                                <Field
                                    name="password"
                                    id="space"
                                    type={passwordtype}
                                    className="col-11 selectbox border rounded"
                                />
                                <button
                                    type="buttonadd"
                                    onClick={handleclick}
                                    className="iconstyle border border-top border-bottom border-right col-1"
                                >
                                    {!visible ? <FaEye /> : <FaEyeSlash />}
                                </button>
                            </div>
                            <ErrorMessage name="password" component={TextError} />
                        </div>
                        <button
                            id="button"
                            type="submit"
                            disabled={!formik.isValid || formik.isSubmitting}
                            className="btn btn-primary col-12 "
                        >
                            Login
                        </button>
                        <div className="row mb-4">
                            <small className="form-text col-9">
                                New User/Admin?<Link to="/Signup">Signup</Link>
                            </small>
                        </div>
                    </Form>
            )}
            </Formik>
        </>
    );
};
export default LoginForm