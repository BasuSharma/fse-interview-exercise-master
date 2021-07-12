import React from "react";
import { useFormik } from "formik";
import styled from "styled-components";
import View from "../../../DesignSystem/View";
import FormInput from "../../../DesignSystem/Form/FormInput";
import SubmitButton from "../../../DesignSystem/Form/SubmitButton";
import Title from "../../../DesignSystem/Title";
import * as Yup from 'yup';
import {INPUT_NAME_ERROR_MSG,INPUT_EMAIL_ERROR_MSG,INPUT_ADDRESS_ERROR_MSG} from "../../../Configuration/ApplicationConstants"

const FormWrapper = styled.div`
  flex: 1 1 auto;
  width: 100%;
`;

interface FormValues {
  name: string;
  email: string;
  address: string;
}

// Component to collect user data in Formik forms and send details to parent conatiner
// Uses submit action from props provided funciton
const EligibilityApplication = (props: { checkApplicantEligiblity: any }) => {
  const formik = useFormik<FormValues>({
    initialValues: {
      name: "",
      email: "",
      address: "",
    },
    validationSchema: Yup.object({
      name: Yup.string()
        .min(3,INPUT_NAME_ERROR_MSG)
        .max(35, INPUT_NAME_ERROR_MSG)
        .required(INPUT_NAME_ERROR_MSG),
      email: Yup.string().email(INPUT_EMAIL_ERROR_MSG).required(INPUT_EMAIL_ERROR_MSG),
      address: Yup.string()
        .min(5,INPUT_ADDRESS_ERROR_MSG)
        .max(55, INPUT_ADDRESS_ERROR_MSG)
        .required(INPUT_ADDRESS_ERROR_MSG),
    }),
    onSubmit: (values) => props.checkApplicantEligiblity(values)
    ,
  });

  return (
    <View>
      <FormWrapper>
        <Title>Cards</Title>
        <form onSubmit={formik.handleSubmit}>
          <FormInput
            type="text"
            id="name"
            {...formik.getFieldProps('name')}
            placeholder="Name"
          />
          {formik.touched.name && formik.errors.name ? (
         <div>{formik.errors.name}</div>
          ) : null}
          <FormInput
            type="email"
            id="email"
            {...formik.getFieldProps('email')}
            placeholder="Email"
          />
          {formik.touched.email && formik.errors.email ? (
            <div>{formik.errors.email}</div>
            ) : null}

          <FormInput
            type="text"
            id="address"
            {...formik.getFieldProps('address')}
            placeholder="Address"
          />
          {formik.touched.address && formik.errors.address ? (
         <div>{formik.errors.address}</div>
          ) : null}
          <SubmitButton text="Submit" />
        </form>
      </FormWrapper>
    </View>
  );
};

export default EligibilityApplication;


