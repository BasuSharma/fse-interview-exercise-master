import React from "react";
import styled from "styled-components";
import View from "../../../DesignSystem/View";
import Card from "../../../DesignSystem/Card";

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

//Component to show results of eligibility check of applicant 
const EligibilityResults = (props: { userName: string, cards: any }) => {
   
    if(props.cards.eligibleCards.length >0)
    {
     return <ResultsWrapper>
        <View>
        <HeadingText> Hi {props.userName}, <br></br> Below are your eligible card/cards </HeadingText>
        {props.cards.eligibleCards.map((card: string) => {
          return <Card key={card}>  {card} </Card>
        })}
      </View>
      <br></br>
      <div><a href="http://localhost:3000/">back</a></div>
      </ResultsWrapper>;
    }
    else{
      return <ResultsWrapper>
        <View>
          <HeadingText> Hi {props.userName}, 
          <br></br>Sorry we don't have any eligible card for you.
          </HeadingText>
      </View>
      <div><a href="http://localhost:3000/">back</a></div>
      </ResultsWrapper>;
    }

 
};
  
export default EligibilityResults;


