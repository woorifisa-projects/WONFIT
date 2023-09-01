import api from "@/api/index.js";

// const findDeposit = () => {
//   return instance.get(`/product/deposit`);
// };

// const findSavings = () => {
//   return instance.get(`/product/savings`);
// };

// const findFund = () => {
//   return instance.get(`/product/fund`);
// };

// export { findDeposit, findSavings, findFund };

export const getApi = async (param) => {
  const { data } = await api({
    method: "get",
    url: param.url,
    data: param.data,
  });
  return data;
};
