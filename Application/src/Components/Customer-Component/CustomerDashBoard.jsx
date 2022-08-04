import React, { useState } from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Navbar, Nav } from "react-bootstrap";
import { Link, Outlet } from "react-router-dom";
import { useAuth } from "../../auth";
import { useNavigate } from "react-router-dom";
function CustomerDashBoard() {
    const[disable,setDisable]=useState(true);
    const auth = useAuth();
    const navigate = useNavigate();
    function handlelogout() {
        auth.logout();
        localStorage.removeItem('id_token');
        navigate("/");
    }
    return (
        <>
            <Navbar id="navbar"expand="lg">
                <Navbar.Brand className="m-3" as={Link} to="">
                    <img src="https://www.pngplay.com/wp-content/uploads/7/Customer-Logo-Transparent-File.png" alt="AVATAR" id="centerimg" />
                </Navbar.Brand>
                <Navbar.Toggle />
                <Navbar.Collapse>
                    <Nav className="me-auto">
                        <Nav.Link as={Link} to="submitForm" className="m-3" id="navbartext">
                            Application Form
                        </Nav.Link>
                        <Nav.Link as={Link} to="choiceConfirm" className="m-3" id="navbartext">
                            Choice Confirmation
                        </Nav.Link>
                    </Nav>
                    <button
                        className="justify-content-end "
                        onClick={handlelogout}>
                        <img src="https://www.iconpacks.net/icons/1/free-user-logout-icon-304-thumb.png" alt="LOGOUT" id="centerimg" />
                    </button>
                </Navbar.Collapse>
            </Navbar>
            <Outlet />
        </>
    );
}
export default CustomerDashBoard;