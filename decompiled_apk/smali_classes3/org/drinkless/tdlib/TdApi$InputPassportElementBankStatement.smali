.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementBankStatement;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementBankStatement"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x195a878


# instance fields
.field public bankStatement:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 14802
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 14803
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;)V
    .locals 0
    .param p1, "inputPersonalDocument"    # Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 14793
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 14794
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementBankStatement;->bankStatement:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 14795
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 14799
    const v0, -0x195a878

    return v0
.end method
