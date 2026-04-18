.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementUtilityBill;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementUtilityBill"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x52cd9181


# instance fields
.field public utilityBill:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15144
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15145
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;)V
    .locals 0
    .param p1, "inputPersonalDocument"    # Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 15135
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15136
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementUtilityBill;->utilityBill:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 15137
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15141
    const v0, 0x52cd9181

    return v0
.end method
