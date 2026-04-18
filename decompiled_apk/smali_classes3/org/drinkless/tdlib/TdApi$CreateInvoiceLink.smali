.class public Lorg/drinkless/tdlib/TdApi$CreateInvoiceLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateInvoiceLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$HttpUrl;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x308f3799


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public invoice:Lorg/drinkless/tdlib/TdApi$InputMessageContent;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24684
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24685
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InputMessageContent;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "inputMessageContent"    # Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 24674
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24675
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CreateInvoiceLink;->businessConnectionId:Ljava/lang/String;

    .line 24676
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$CreateInvoiceLink;->invoice:Lorg/drinkless/tdlib/TdApi$InputMessageContent;

    .line 24677
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24681
    const v0, -0x308f3799

    return v0
.end method
