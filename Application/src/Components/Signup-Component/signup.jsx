import { Modal } from "react-bootstrap";
import SignupForm from "./SF.jsx";
export default function Signup() {
    const showModal = true;
    const fullscreen = true;
    return (
        <Modal show={showModal} fullscreen={fullscreen} centered size="lg">
            <Modal.Body id ="bgcolor">
                <img src="https://www.pngall.com/wp-content/uploads/12/Avatar-Profile-PNG-Picture.png" alt="AVATAR" id="centeraddlogo" />
                <div className="row justify-content-center">
                    <div class="col-14 col-md-4">
                        <SignupForm/>
                    </div></div>
            </Modal.Body>
        </Modal>
    );
}
