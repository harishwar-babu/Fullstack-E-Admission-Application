import { Modal } from "react-bootstrap";
import Admindashboardupdatecollegedetails from "./UpdateCollegeProfile";
export default function UpdateCollege() {
    const showModal = true;
    const fullscreen = false
    return (
        <Modal show={showModal} fullscreen={fullscreen} centered size="lg">
        <Modal.Body id="bgcolor">
                <img src="https://media.istockphoto.com/vectors/color-logo-of-the-school-vector-id1150645589?k=20&m=1150645589&s=612x612&w=0&h=2xbp-Zrro_3e0soj3-sF2bvQWIsX7yAHNa5fHIwFz80=" 
                alt="COLLEGE AVATAR" id="centeraddlogo" />
            <div className="row justify-content-center">
                <div class="col-14 col-md-4">
                    <Admindashboardupdatecollegedetails />
                </div></div>
        </Modal.Body>
        </Modal>
    );
}
