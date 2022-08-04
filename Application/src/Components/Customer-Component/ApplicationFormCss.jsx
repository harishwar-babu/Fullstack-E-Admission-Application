import { Modal } from "react-bootstrap";
import ApplicationForm from "./ApplicationForm";
export default function AddForm() {
    return (
        <Modal.Body id="bgcolor">
            <img src="https://cdn2.iconfinder.com/data/icons/character-avatar/64/30-people-avatar-512.png" alt="GRADUATE AVATAR" id="centeraddlogo" />
            <div className="row justify-content-center">
                <div class="col-14 col-md-4">
                    <ApplicationForm />
                </div></div>
        </Modal.Body>
    );
}
