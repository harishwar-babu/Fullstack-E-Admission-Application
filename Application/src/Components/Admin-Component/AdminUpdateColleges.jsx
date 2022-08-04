import React, { useState, useEffect } from "react";
import { Table } from "react-bootstrap";
import { RiDeleteBin5Fill } from "react-icons/ri";
import { FaEdit } from "react-icons/fa";
import { useNavigate, Outlet, useParams } from "react-router-dom";
import adminservice from "../Services/adminservice";
import ReactPaginate from "react-paginate";
function Admindashboardupdatecolleges() {
    const navigate = useNavigate();
    const [CollegeList, setCollegeList] = useState([]);
    useEffect(() => {
        adminservice.fetchCollegeList().then((res) => {
            setCollegeList(res.data);
            /*setTimeout(function () {
                window.location.reload();
            }, 10000)*/
        });
    }, []);
    function remove(id,name) {
        alert("delete name is " + name);
        window.location.reload();
        adminservice.deleteClgs(id)
            .then((res) => {
                const editedlist = CollegeList.filter((college) => college.id !== id);
                setCollegeList(editedlist);
            })
            .catch((err) => console.log(err));
    }
    const [pageNumber, setPageNumber] = useState(0);
    const collegesPerPage = 5;
    const pagesVisited = pageNumber * collegesPerPage;
    const current = CollegeList.slice(pagesVisited, pagesVisited + collegesPerPage);
    const pageCount = Math.ceil(CollegeList.length / collegesPerPage);

    const changePage = ({ selected }) => {
        setPageNumber(selected);
    };
    return (
        <>
            <img src="https://media.istockphoto.com/vectors/color-logo-of-the-school-vector-id1150645589?k=20&m=1150645589&s=612x612&w=0&h=2xbp-Zrro_3e0soj3-sF2bvQWIsX7yAHNa5fHIwFz80=" 
            alt="COLLEGE AVATAR" id="centeraddlogo" />
            <div className="container d-flex align-item-center">
                <Table className="m-4">
                    <thead>
                        <tr>
                            <th className="p-3" id="tablerowcolor">Name</th>
                            <th className="p-3" id="tablerowcolor">Code</th>
                            <th className="p-3" id ="tablerowcolor">District</th>
                            <th className="p-3" id="tablerowcolor">MinCutOff</th>
                            <th className="p-3" id = "tablerowcolor"> MaxCutOff</th>
                            <th colSpan={2}></th>
                        </tr>
                    </thead>
                    <tbody>
                        {current.map((college) => (
                            <tr key={college.code}>
                                <td className="p-3" id="tablecolor">{college.name}</td>
                                <td className="p-3" id="tablecolor">{college.code}</td>
                                <td className="p-3" id="tablecolor">{college.district}</td>
                                <td className="p-3" id="tablecolor"> {college.mincutoff}</td>
                                <td className="p-3" id="tablecolor">{college.maxcutoff}</td>
                                <td className="p-3" id="tablecolor">
                                    <button
                                        onClick={() => navigate("UpdateCollegeProfile/" + college.code)}
                                        className="btn btn-lg btn-success d-flex align-items-center "
                                    >
                                        <FaEdit />
                                    </button>
                                    </td>
                                    <td className="p-3" id="tablecolor">                                    
                                    <button
                                        onClick={() => remove(college.code,college.name)}
                                        className="btn btn-lg btn-danger d-flex align-items-center "
                                    >
                                        <RiDeleteBin5Fill />
                                    </button>
                                </td>
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
export default  Admindashboardupdatecolleges;