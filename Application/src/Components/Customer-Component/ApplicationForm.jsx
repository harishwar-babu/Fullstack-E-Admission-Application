import React, { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import "bootstrap/dist/css/bootstrap.min.css";
import TextError from "../../TextError.jsx";
import * as Yup from "yup";
import Input from "../../input.jsx";
import applicationservice from "../Services/applicationservice.jsx";
import { useNavigate } from "react-router";
import { FaWindows } from "react-icons/fa";
function ApplicationForm() {
    const navigate=useNavigate();
    const initialValues = {
        name: "",
        dob:"",
        mbno:"",
        email:"",
        sslc:'',
        hslc:'',
        department:''
    };
    const onSubmit = (values, onSubmitProps) => {
        console.log("form data", values);
        applicationservice.submit(values).then((res) => {
                alert(res.data);
                console.log(values);
            onSubmitProps.setSubmitting(false);
            onSubmitProps.resetForm();
            });
    };
    const depts = [
        { key: "select A Department", value: "" },
        { key: "Computer Science And Engineering", value: "Computer Science And Engineering" },
        { key: "Information Technology", value: "Information Technology" },
        { key: "Mechanical Engineering", value: "Mechanical Engineering" },
        { key: "Electronics And Communication Engineering", value: "Electronics And Communication Engineering" },
        { key: "Artificial Intelligence And Data Science", value: "Artificial Intelligence And Data Science"}
    ];
    const validationSchema = Yup.object({
        name: Yup.string()
            .matches(/^[a-zA-Z0-9\s]*$/, "Must contain Alphabets Only")
            .required("Name is required"),
        dob: Yup.date("Enter a Valid Date")
            .required("Date is required"),
        mbno: Yup.string()
            .matches("^\\d{10}$", "Please enter a valid Mobilenumber")
            .required("Mobile Number is required"),
        email: Yup.string().email("Enter a Valid Email")
            .required("Email Required"),
        sslc: Yup.number("Enter a Valid SSLC Mark")
            .required("SSLC Mark is required"),        
        hslc:Yup.number("Enter a Valid HSLC CUT-OFF")
             .required("ENTER HSLC CUTOFF (OUT OF 200)"),
        department: Yup.string()
            .matches(/^[a-zA-Z0-9\s]*$/, "Must contain Alphabets Only")
            .required("Department is required")
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
                        <Input name="name" label="Name" type="text" id="space"/>
                        <Input name="dob" label="Date Of Birth" type="date" id="space"/>
                        <Input name="mbno" label="Active Mobile Number" type="text" id="space"/>
                        <Input name="email" label="Active Email Id" type="email" id="space"/>
                        <Input name="sslc" label="SSLC % (OUT OF 100)" type="number" id="space" />
                        <Input name="hslc" label="HSLC CUTOFF % (OUT OF 200)" type="number" id="space"/>
                        <div>
                            <label htmlFor="department" className="mt-2">
                                Department
                            </label>
                            <select
                                name="department"
                                id="space"
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}
                                value={formik.values.productavailableSlots}
                                className="d-block col-12  border selectbox border rounded"
                                style={{ height: 40 }}
                            >
                                {depts.map((option) => (
                                    <option key={option.key} value={option.value}>
                                        {option.key}
                                    </option>
                                ))}
                            </select>
                            {formik.touched.department &&
                                formik.errors.department ? (
                                <TextError>
                                    {formik.errors.department}
                                </TextError>
                            ) : null}
                        </div>
                        <button
                            type="submit"
                            id="buttonadd"
                            disabled={!formik.isValid || formik.isSubmitting}
                            className="btn btn-primary col-12"
                        >
                            Submit Application
                        </button>
                        </Form>
                )}
            </Formik>
        </>
    );
}
export default ApplicationForm;