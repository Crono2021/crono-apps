.class public Lorg/drinkless/tdlib/TdApi$InternalLinkTypeInvoice;
.super Lorg/drinkless/tdlib/TdApi$InternalLinkType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InternalLinkTypeInvoice"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xcb39254


# instance fields
.field public invoiceName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15360
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15361
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 15351
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InternalLinkType;-><init>()V

    .line 15352
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InternalLinkTypeInvoice;->invoiceName:Ljava/lang/String;

    .line 15353
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15357
    const v0, -0xcb39254

    return v0
.end method
