import React, { useState, useEffect } from "react";
import { Table } from "react-bootstrap";
import { Formik, Form, Field, ErrorMessage, validateYupSchema } from "formik";
import { useNavigate, Outlet, useParams, Navigate } from "react-router-dom";
import { Modal } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import TextError from "../../TextError.jsx";
import * as Yup from "yup";
import Input from "../../input.jsx";
import applicationservice from "../Services/applicationservice.jsx";
import ReactPaginate from "react-paginate";
function ChoiceConfirmationForm()
{
    const navigate=useNavigate();
    const initialValues = {
        appid:'',
        code:''
    };
    const onSubmit = (values, onSubmitProps) => {
        applicationservice.confirmation(values).then((res)=>{
            alert(res.data);
            onSubmitProps.setSubmitting(false);
            onSubmitProps.resetForm();
        });
    }

    const validationSchema = Yup.object({
        appid: Yup.string()
            .matches(/^[a-zA-Z0-9\s]*$/, "Must contain Alphanumeric Characters Only")
            .required("Application ID is required"),
        code: Yup.string()
            .matches(/^[a-zA-Z0-9\s]*$/, "Must contain Alphabets Only")
            .required("Name is required")
    });
    return (
        <>
            <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={onSubmit}
            >
                {(formik) => (
                    <Form className="container border border-secondary" id="bgformcolor">
                        <Input name="appid" label="Application ID" type="text" id="space" />
                        <Input name="code" label="CollegeCode" type="text" id="space"/>
                        <button
                            type="submit"
                            id="buttonadd"
                            disabled={!formik.isValid || formik.isSubmitting}
                            className="btn btn-primary col-12"
                        >
                            Confirm Choice
                        </button>
                    </Form>
                )}
            </Formik>
        </>
    );
}
export default ChoiceConfirmationForm;