import * as Styled from "./styled"

export default function ModalBox({ children }) {

  return (
    <Styled.Modal>
      <Styled.Content>
        {children}
      </Styled.Content>
    </Styled.Modal> 
  );
}