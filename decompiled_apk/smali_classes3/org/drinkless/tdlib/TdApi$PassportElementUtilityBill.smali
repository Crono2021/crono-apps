.class public Lorg/drinkless/tdlib/TdApi$PassportElementUtilityBill;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementUtilityBill"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xdfbe22e


# instance fields
.field public utilityBill:Lorg/drinkless/tdlib/TdApi$PersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17646
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17647
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PersonalDocument;)V
    .locals 0
    .param p1, "personalDocument"    # Lorg/drinkless/tdlib/TdApi$PersonalDocument;

    .line 17637
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17638
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementUtilityBill;->utilityBill:Lorg/drinkless/tdlib/TdApi$PersonalDocument;

    .line 17639
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17643
    const v0, -0xdfbe22e

    return v0
.end method
