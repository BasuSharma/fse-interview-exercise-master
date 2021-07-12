import React from 'react';
import { screen } from '@testing-library/react';
import Enzyme, { shallow, render, mount } from 'enzyme';
import toJson, { Json } from 'enzyme-to-json';
import Adapter from '@wojtekmaj/enzyme-adapter-react-17';
import EligibilityResults from './EligibilityResults';

Enzyme.configure({ adapter: new Adapter() })

let cardsData = {cards:{
                            eligibleCards:[
                                            "C1",
                                            "C2"
                                        ]
                                        },
                    };


it("renders correctly", () => {
  const testresultcomponent = shallow(<EligibilityResults  userName={"Anjela"} cards= {cardsData.cards} />);
  expect(toJson(testresultcomponent)).toMatchSnapshot();
});
