.class public Lorg/drinkless/tdlib/TdApi$PassportElementBankStatement;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementBankStatement"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x15d7cd98


# instance fields
.field public bankStatement:Lorg/drinkless/tdlib/TdApi$PersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17394
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17395
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$PersonalDocument;)V
    .locals 0
    .param p1, "personalDocument"    # Lorg/drinkless/tdlib/TdApi$PersonalDocument;

    .line 17385
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17386
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementBankStatement;->bankStatement:Lorg/drinkless/tdlib/TdApi$PersonalDocument;

    .line 17387
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17391
    const v0, -0x15d7cd98

    return v0
.end method
