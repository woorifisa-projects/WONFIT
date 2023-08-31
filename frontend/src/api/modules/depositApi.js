import { instance } from "@/api/index.js";

const findDeposit = () => {
  return instance.get(`/product/deposit`);
};

export { findDeposit };
