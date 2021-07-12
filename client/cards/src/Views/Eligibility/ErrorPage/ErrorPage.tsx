import styled from "styled-components";
import View from "../../../DesignSystem/View";

const ResultsWrapper = styled.div`
  flex: 1 1 auto;
  padding-top: 48px;
  justify-content: center;
  margin: 0 -8px;
  display: flex;
  flex-wrap: wrap;
`;

const HeadingText = styled.div`
  flex: 1 1 auto;
  width: 80%;
  padding-top: 10px;
  padding-bottom:10px;
  justify-content: center;
  display: flex;
  flex-wrap: wrap;
  border-radius: 1px;
  border: solid .5px #eee;
  min-height: 50px;
  font-size: 25px;
  font-weight: bold;
  text-align: center;
  color: rgb(42, 98, 231, 0.75);
`;

// Error  page to show generic handled errors related to application 
const ErrorPage = () => {
  
  
     return <ResultsWrapper>
        <View>
        <HeadingText>Error Occured. please try agian later or contact support. </HeadingText>
         </View>
       </ResultsWrapper>;
   

 
};
  
export default ErrorPage;


