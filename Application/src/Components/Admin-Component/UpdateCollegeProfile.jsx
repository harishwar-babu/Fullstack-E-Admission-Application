import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import "bootstrap/dist/css/bootstrap.min.css";
import TextError from "../../TextError.jsx";
import { Modal } from "react-bootstrap";
import * as Yup from "yup";
import Input from "../../input.jsx";
import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import adminservice from "../Services/adminservice.jsx";
import { FaWindows } from "react-icons/fa";
function Admindashboardupdatecollegedetails() {
    const navigate = useNavigate();
    const {id} = useParams();
    const [initialValues, setInitialValues] = useState({});
    useEffect(() => {
        adminservice.fetchCollgeById(id)
            .then((res) => {
                const Collegedetails = {
                    name: res.data.name,
                    mincutoff: res.data.mincutoff,
                    maxcutoff: res.data.maxcutoff
                };
                setInitialValues(Collegedetails);
            })
            .catch((err) => console.log(err));
    }, []);
    const onSubmit = (values, onSubmitProps) => {
        console.log("form-data",values);
        adminservice.Count(values.name).then((res) =>{
            if(res.data==0)
            {
                adminservice.updatecollegedetailsbyid(id,values).then((res) =>{
                    alert("Updated Successfully");
                    navigate(-1);
                })
                    .catch((err) => console.log(err));
            }
            else
            {
                alert("College name already exists");
                navigate(-1);
            }
        })
        window.location.reload();
    }
                
    const districts = [
        { key: "select A District", value: "" },
        { key: "Ariyalur", value: "Ariyalur" },
        { key: "Chengalpattu", value: "Chengalpattu" },
        { key: "Chennai", value: "Chennai" },
        { key: "Coimbatore", value: "Coimbatore" },
        { key: "Cuddalore", value: "Cuddalore" },
        { key: "Dharmapuri", value: "Dharmapuri" },
        { key: "Dindigul", value: "Dindigul" },
        { key: "Erode", value: "Erode" },
        { key: "Kallakurichi", value: "Kallakuruchi" },
        { key: "Kanchipuram", value: "Kanchipuram" },
        { key: "Kanyakumari", value: "Kanyakumari" },
        { key: "Krishnagiri", value: "Krishnagiri" },
        { key: "karur", value: "Karur" },
        { key: "Madurai", value: "Madurai" },
        { key: "Nagapattinam", value: "Nagapattinam" },
        { key: "Namakkal", value: "Namakkal" },
        { key: "Nilgiris", value: "Nilgiris" },
        { key: "Perambalur", value: "Perambalur" },
        { key: "Pudukottai", value: "Pudukottai" },
        { key: "Ramanathapuram", value: "Ramanathapuram" },
        { key: "Ranipet", value: "Ranipet" },
        { key: "Salem", value: "Salem" },
        { key: "Sivaganga", value: "Sivaganga" },
        { key: "Tiruchirapalli", value: "Tiruchirapalli" },
        { key: "Thanjavur", value: "Thanjavur" },
        { key: "Vellore", value: "Vellore" },
        { key: "Villupuram", value: "Villupuram" },

    ];
    const validationSchema = Yup.object({
        name: Yup.string()
            .matches(/^[a-zA-Z0-9\s]*$/, "Must contain Alphabets Only")
            .required("Name is required"),
        district: Yup.string()
            .matches(/^[a-zA-Z0-9\s]*$/, "Must contain Alphabets Only")
            .required("District is required"),
        mincutoff: Yup.number("Enter a Valid Minimum cutoff")
            .required("Minimum Cutoff required"),
        maxcutoff: Yup.number("Enter a Valid Maximum cutoff")
            .required("Maximum Cutoff is required")
    });
    return (
    <>
                    <Formik
                        initialValues={initialValues}
                        onSubmit={onSubmit}
                        validationSchema={validationSchema}
                        enableReinitialize
                    >
                        {(formik) => (
                            <Form className="container border border-secondary" id="bgformcolor">
                                <Input name="name" label="Name" type="text" id="space" />
                        <div>
                            <label htmlFor="district" className="mt-2">
                                District
                            </label>
                            <select
                                name="district"
                                id="space"
                                onChange={formik.handleChange}
                                onBlur={formik.handleBlur}
                                value={formik.values.productavailableSlots}
                                className="d-block col-12  border selectbox border rounded"
                                style={{ height: 40 }}
                            >
                                {districts.map((option) => (
                                    <option key={option.key} value={option.value}>
                                        {option.key}
                                    </option>
                                ))}
                            </select>
                            {formik.touched.district &&
                                formik.errors.district ? (
                                <TextError>
                                    {formik.errors.district}
                                </TextError>
                            ) : null}
                        </div>
                                <Input name="mincutoff" label="MinCutoff" type="number" id="space"/>
                                <Input name="maxcutoff" label="MaxCutoff" type="number" id="space"/>

                                <button
                                    type="submit"
                                    id="buttonadd"
                                    disabled={!formik.isValid || formik.isSubmitting}
                                    className="btn btn-primary col-12">
                                Update College
                                </button>
                            </Form>
                        )}
                    </Formik>
        </>
    );
}
export default Admindashboardupdatecollegedetails;