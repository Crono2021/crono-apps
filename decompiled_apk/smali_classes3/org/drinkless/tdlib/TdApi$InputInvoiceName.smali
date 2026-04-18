.class public Lorg/drinkless/tdlib/TdApi$InputInvoiceName;
.super Lorg/drinkless/tdlib/TdApi$InputInvoice;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputInvoiceName"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e35e90d


# instance fields
.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14694
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInvoice;-><init>()V

    .line 14695
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 14685
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputInvoice;-><init>()V

    .line 14686
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputInvoiceName;->name:Ljava/lang/String;

    .line 14687
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14691
    const v0, -0x4e35e90d

    return v0
.end method
