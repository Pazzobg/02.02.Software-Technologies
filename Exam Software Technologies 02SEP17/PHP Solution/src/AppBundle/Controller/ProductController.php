<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Product;
use AppBundle\Form\ProductType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class ProductController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
        $productRepo = $this->getDoctrine()->getRepository(Product::class);
        $products = $productRepo->findAll();

        return $this->render('product/index.html.twig', ['products' => $products]);
	}

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        $product = new Product();

        $form = $this->createForm(ProductType::class, $product);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            if ($product->getPriority() === null ||
                $product->getName() === null ||
                $product->getQuantity() === null ||
                $product->getStatus() === null) {
                return $this->redirectToRoute('create');
            }

            $em = $this->getDoctrine()->getManager();
            $em->persist($product);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('product/create.html.twig', array('form' => $form->createView()));
	}

    /**
     * @Route("/edit/{id}", name="edit")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function edit($id, Request $request)
    {
        $productForEdit = $this->getDoctrine()->getRepository(Product::class)->find($id);

        if ($productForEdit === null) {
            return $this->redirectToRoute('index');
        }

        $form = $this->createForm(ProductType::class, $productForEdit);
        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid()) {
            if ($productForEdit->getPriority() === null ||
                $productForEdit->getName() === null ||
                $productForEdit->getQuantity() === null ||
                $productForEdit->getStatus() === null) {
                return $this->redirectToRoute('index');
            }

            $em = $this->getDoctrine()->getManager();
            $em->merge($productForEdit);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('product/edit.html.twig', ['product' => $productForEdit, 'form' => $form->createView()]);
    }
}
