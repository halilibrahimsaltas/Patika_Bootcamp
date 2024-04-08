--
-- PostgreSQL database dump
--

-- Dumped from database version 16.2
-- Dumped by pg_dump version 16.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Book; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Book" (
    book_id integer NOT NULL,
    book_car_id integer NOT NULL,
    book_name text NOT NULL,
    book_idno text NOT NULL,
    book_mpno text NOT NULL,
    book_mail text,
    book_strt_date date NOT NULL,
    book_fnsh_date date NOT NULL,
    book_prc integer NOT NULL,
    book_note text,
    book_case text NOT NULL
);


ALTER TABLE public."Book" OWNER TO postgres;

--
-- Name: Book_book_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Book" ALTER COLUMN book_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Book_book_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: Brand; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Brand" (
    brand_id integer NOT NULL,
    brand_name text NOT NULL
);


ALTER TABLE public."Brand" OWNER TO postgres;

--
-- Name: Brand_brand_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Brand" ALTER COLUMN brand_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Brand_brand_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: Car; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Car" (
    car_id integer NOT NULL,
    car_model_id integer NOT NULL,
    car_color text NOT NULL,
    car_km integer NOT NULL,
    car_plate text NOT NULL
);


ALTER TABLE public."Car" OWNER TO postgres;

--
-- Name: Car_car_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Car" ALTER COLUMN car_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Car_car_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: Model; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Model" (
    model_id integer NOT NULL,
    model_brand_id integer NOT NULL,
    model_name text NOT NULL,
    model_type text NOT NULL,
    model_year text NOT NULL,
    model_fuel text NOT NULL,
    model_gear text NOT NULL
);


ALTER TABLE public."Model" OWNER TO postgres;

--
-- Name: Model_model_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."Model" ALTER COLUMN model_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."Model_model_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: User; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."User" (
    user_id bigint NOT NULL,
    user_name text NOT NULL,
    user_password text NOT NULL,
    user_role text NOT NULL
);


ALTER TABLE public."User" OWNER TO postgres;

--
-- Name: User_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public."User" ALTER COLUMN user_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public."User_user_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: Book; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Book" (book_id, book_car_id, book_name, book_idno, book_mpno, book_mail, book_strt_date, book_fnsh_date, book_prc, book_note, book_case) FROM stdin;
1	3	Halil SALTAS	45151531564	05336589954	kocks@yahoo.com	2022-10-12	2023-01-31	80000	azg	done
4	2	Cihan TEKEL	4865545165	05365984578	gıyadm@exakp.com	2023-05-07	2023-06-16	20000	tpdkkt	done
6	9	Lokman SIRDAS	4518516611	05327456235	lokmandc@sifa.com	2023-08-10	2023-09-15	25000	doc	nope
\.


--
-- Data for Name: Brand; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Brand" (brand_id, brand_name) FROM stdin;
1	Volkswagen
3	Toyota
2	Nissan
5	BMW
8	Fiat
7	Opel
\.


--
-- Data for Name: Car; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Car" (car_id, car_model_id, car_color, car_km, car_plate) FROM stdin;
1	3	WHITE	110000	34 TYT 6263
2	1	BLACK	180000	75 LLT 645
3	2	BLACK	75000	58 LYO 8565
4	6	GREEN	50000	06 MMO 1452
5	7	BLUE	175000	34 ERT 7899
6	8	AQUA	40000	34 DR 3341
7	9	RED	220000	34 TP 159
8	10	WHITE	89000	34 KT 478
9	11	WHITE	62000	35 CDM 639
\.


--
-- Data for Name: Model; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."Model" (model_id, model_brand_id, model_name, model_type, model_year, model_fuel, model_gear) FROM stdin;
1	5	M3	SEDAN	2007	DIESEL	MANUEL
2	1	Passat	SEDAN	2011	GASOLINE	MANUEL
3	3	Corrolla	SEDAN	2014	DIESEL	MANUEL
6	8	500e	HACBACK	2020	ELECTRIC	AUTO
7	8	Lounge	HACBACK	2017	DIESEL	AUTO
8	1	Golf	HACBACK	2022	GASOLINE	MANUEL
9	5	320i	SEDAN	2016	GASOLINE	AUTO
10	2	Pulsar	HACBACK	2016	GASOLINE	MANUEL
11	7	Insignia	SEDAN	2019	DIESEL	AUTO
\.


--
-- Data for Name: User; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."User" (user_id, user_name, user_password, user_role) FROM stdin;
1	admin	1234	admin
\.


--
-- Name: Book_book_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Book_book_id_seq"', 6, true);


--
-- Name: Brand_brand_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Brand_brand_id_seq"', 8, true);


--
-- Name: Car_car_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Car_car_id_seq"', 9, true);


--
-- Name: Model_model_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Model_model_id_seq"', 11, true);


--
-- Name: User_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."User_user_id_seq"', 1, true);


--
-- Name: Book Book_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Book"
    ADD CONSTRAINT "Book_pkey" PRIMARY KEY (book_id);


--
-- Name: Brand Brand_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Brand"
    ADD CONSTRAINT "Brand_pkey" PRIMARY KEY (brand_id);


--
-- Name: Car Car_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Car"
    ADD CONSTRAINT "Car_pkey" PRIMARY KEY (car_id);


--
-- Name: Model Model_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Model"
    ADD CONSTRAINT "Model_pkey" PRIMARY KEY (model_id);


--
-- Name: User User_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."User"
    ADD CONSTRAINT "User_pkey" PRIMARY KEY (user_id);


--
-- PostgreSQL database dump complete
--

