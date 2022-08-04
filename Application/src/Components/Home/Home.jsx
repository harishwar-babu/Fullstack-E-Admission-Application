import React from "react";
import { useNavigate } from "react-router-dom";
import "./Home.css";
import { Modal } from "react-bootstrap";
export default function Home() {
    const showModal = true;
    const fullscreen = true;
    let navigate = useNavigate();
    const routeChange = () => {
        let path = `/Login`;
        navigate(path);
    };

    const routeChangeSignup = () => {
        let path = "/signup";
        navigate(path);
    };
    return (
        <Modal show={showModal} fullscreen={fullscreen} centered size="lg" >
            <Modal.Body id="image"> 
                <div className="col-md-12 text-center">
                    <h1 className="animate-charcter">ENGINEERING ADMISSIONS-2022</h1>
                </div>
                <div className="row justify-content-center">
                    <div className="col-12 col-md-4">
                        <img src="https://previews.123rf.com/images/captainvector/captainvector1703/captainvector170309311/74165534-college-logo-element.jpg"
                         id="homeimg"/>
                            <button  id="hbutton" className="btn btn-info" onClick={routeChange}>
                                Login
                            </button>
                            <button  id="hbutton2" className="btn btn-info" onClick={routeChangeSignup}>
                                Signup
                            </button>
                    </div>
                </div>    
            </Modal.Body>
        </Modal>
    );
}