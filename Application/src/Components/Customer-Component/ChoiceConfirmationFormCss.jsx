import { Modal } from "react-bootstrap";
import ChoiceConfirmationForm from "./ChoiceConfirmationForm";
export default function ChoiceForm() {
    const showModal = true;
    const fullscreen = false
    return (
        <Modal.Body>
            <img src="https://cdn2.iconfinder.com/data/icons/character-avatar/64/30-people-avatar-512.png" alt="GRADUATE AVATAR" id="centeraddlogo" />
            <div className="row justify-content-center">
                <div class="col-14 col-md-4">
                    <ChoiceConfirmationForm />
                </div></div>
        </Modal.Body>
    );
}

