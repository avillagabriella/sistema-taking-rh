import React, { useState } from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";
import PropTypes from "prop-types";

function Remove(props) {
  const { className } = props;

  const [modal, setModal] = useState(false);
  const toggle = () => setModal(!modal);

  return (
    <div>
      <input
        class="button-remover"
        type="button"
        s
        value="Remover"
        onClick={toggle}
      />
      <Modal isOpen={modal} toggle={toggle} centered className={className}>
        <ModalHeader toggle={toggle} />

        <ModalBody>Você tem certeza que deseja remover esse usuário?</ModalBody>
        <ModalFooter>
          <Button color="danger" onClick={toggle}>
            Sim
          </Button>{" "}
          <Button color="secondary" onClick={toggle}>
            Não
          </Button>
        </ModalFooter>
      </Modal>
    </div>
  );
}

Remove.propTypes = {
  className: PropTypes.string,
};

export default Remove;
