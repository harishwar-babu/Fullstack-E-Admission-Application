import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import { Navbar, Nav } from "react-bootstrap";
import { Link, Outlet } from "react-router-dom";
import { useAuth } from "../../auth";
import { useNavigate } from "react-router-dom";
import { Table } from "react-bootstrap";
function AdminDashBoard() {
    const auth = useAuth();
    const navigate = useNavigate();
    function handlelogout() {
        auth.logout();
        localStorage.removeItem('id_token');
        navigate("/");
    }
    return (
        <>
            <Navbar id="navbar" expand="lg">
                <Navbar.Brand className="m-3" as={Link} to="">
                    <img src="https://www.pngitem.com/pimgs/m/226-2260470_transparent-admin-icon-png-admin-logo-png-png.png" alt="AVATAR" id="centerimg"/> 
                </Navbar.Brand>
                <Navbar.Toggle />
                <Navbar.Collapse>
                    <Nav className="me-auto">
                        <Nav.Link as={Link} to="addCollege" className="m-3" id="navbartext">
                            Add College
                        </Nav.Link>
                        <Nav.Link as={Link} to="ViewColleges" className="m-3" id="navbartext">
                            College Profile
                        </Nav.Link>
                        <Nav.Link as={Link} to="CollegeProfile" className="m-3" id="navbartext">
                            Update College Profile
                        </Nav.Link>
                        <Nav.Link as={Link} to="ViewUsers" className="m-3" id="navbartext">
                            User Profile
                        </Nav.Link>
                        <Nav.Link as={Link} to="UserChoiceSelection" className="m-3" id="navbartext">
                            User Choice Selection
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
export default AdminDashBoard;
