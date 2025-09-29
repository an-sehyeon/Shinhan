export const springPath = process.env.REACT_APP_SPRING_FRAMEWORK_URL;

export const initEmp = {
  employee_id: "",
  first_name: "",
  last_name: "",
  email: "",
  phone_number: "",
  hire_date: "",
  salary: "",
  commission_pct: "",
  manager_id: "",
  department_id: "",
  photos: "",
  job_id: "",
};

export const sanitizeNullToEmpty = (obj) => {
  const result = {};
  for (const key in initEmp) {
    result[key] =
      obj[key] === null || obj[key] === undefined
        ? typeof initEmp[key] === "number"
          ? 0
          : ""
        : obj[key]; // null 또는 undefined → ""
  }
  return result;
};
