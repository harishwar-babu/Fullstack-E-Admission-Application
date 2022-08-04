import React, { useState, useEffect } from "react";
import { Table } from "react-bootstrap";
import { RiDeleteBin5Fill } from "react-icons/ri";
import { FaEdit } from "react-icons/fa";
import { useNavigate, Outlet, useParams } from "react-router-dom";
import adminservice from "../Services/adminservice";
import ReactPaginate from "react-paginate";
function Admindashboardviewchoices() {
    const navigate = useNavigate();
    const [ChoiceList, setChoiceList] = useState([]);
    useEffect(() => {
        adminservice.ChoiceList().then((res) => {
            setChoiceList(res.data);
        });
    }, []);
    const [pageNumber, setPageNumber] = useState(0);
    const choicePerPage = 5;
    const pagesVisited = pageNumber * choicePerPage;
    const current = ChoiceList.slice(pagesVisited, pagesVisited + choicePerPage);
    const pageCount = Math.ceil(ChoiceList.length / choicePerPage);

    const changePage = ({ selected }) => {
        setPageNumber(selected);
    };
    return (
        <>
            <img src="https://cdn2.iconfinder.com/data/icons/character-avatar/64/30-people-avatar-512.png" 
            alt="GRADUATE AVATAR" id="centeraddlogo" />
            <div className="container d-flex align-item-center">
                <Table className="m-4">
                    <thead>
                        <tr>
                            <th className="p-2" id="tablerowcolor">Application ID</th>
                            <th className="p-2"id="tablerowcolor">Selected College Code</th>
                        </tr>
                    </thead>
                    <tbody>
                        {current.map((choice) => (
                            <tr key={choice.id}>
                                <td className="p-2"id="tablecolor">{choice.appid}</td>
                                <td className="p-2" id="tablecolor">{choice.code}</td>
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
export default Admindashboardviewchoices;