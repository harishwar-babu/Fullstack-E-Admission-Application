import React, { useState, useEffect } from "react";
import { Table } from "react-bootstrap";
import { RiDeleteBin5Fill } from "react-icons/ri";
import { FaEdit } from "react-icons/fa";
import { useNavigate, Outlet, useParams } from "react-router-dom";
import adminservice from "../Services/adminservice";
import ReactPaginate from "react-paginate";
function Admindashboardviewusers() {
    const navigate = useNavigate();
    const [UserList, setUserList] = useState([]);
    useEffect(() => {
        adminservice.fetchUserList().then((res) => {
            setUserList(res.data);
            console.log(res);
        });
    }, []);
    const [pageNumber, setPageNumber] = useState(0);
    const USersPerPage = 5;
    const pagesVisited = pageNumber * USersPerPage;
    const current = UserList.slice(pagesVisited, pagesVisited + USersPerPage);
    const pageCount = Math.ceil(UserList.length / USersPerPage);
    const changePage = ({ selected }) => {
        setPageNumber(selected);
    };
    return (
        <>
            <img src="https://cdn2.iconfinder.com/data/icons/character-avatar/64/30-people-avatar-512.png" alt="GRADUATE AVATAR" id="centeraddlogo" />
            <div className="container d-flex align-item-center">
                <Table hover id="tablecolor"className="m-4">
                    <thead>
                        <tr>
                            <th className="p-3" id="tablerowcolor">ApplicationID</th>
                            <th className="p-3" id="tablerowcolor">Name</th>
                            <th className="p-3" id="tablerowcolor">DOB</th>
                            <th className="p-3" id="tablerowcolor">Mobile Number</th>
                            <th className="p-3" id="tablerowcolor"> E-Mail</th>
                            <th className="p-3" id="tablerowcolor"> SSLC MARKS</th>
                            <th className="p-3" id="tablerowcolor"> HSLC MARKS</th>
                        </tr>
                    </thead>
                    <tbody>
                        {current.map((users) => (
                            <tr key={users.id}>
                                <td className="p-3" id="tablecolor">{users.id}</td>
                                <td className="p-3" id="tablecolor">{users.name}</td>
                                <td className="p-3" id="tablecolor">{users.dob}</td>
                                <td className="p-3" id="tablecolor">{users.mbno}</td>
                                <td className="p-3" id="tablecolor"> {users.email}</td>
                                <td className="p-3" id="tablecolor">{users.sslc}</td>
                                <td className="p-3" id="tablecolor">{users.hslc}</td>
                            </tr>
                        ))}
                    </tbody>
                </Table>

            </div>
            <ReactPaginate
                previousLabel={"Previous"}
                nextLabel={"Next"}
                breakLabel={"..."}
                marginPagesDisplayed={2}
                pageRangeDisplayed={3}
                pageCount={pageCount}
                onPageChange={changePage}
                pageClassName={"page-item"}
                pageLinkClassName={"page-link"}
                previousClassName={"page-item"}
                previousLinkClassName={"page-link"}
                nextClassName={"page-item"}
                nextLinkClassName={"page-link"}
                breakClassName={"page-item"}
                breakLinkClassName={"page-link"}
                activeClassName={"active"}
                containerClassName={"pagination justify-content-center"}

            />
            <Outlet />
        </>
    );
}
export default Admindashboardviewusers;