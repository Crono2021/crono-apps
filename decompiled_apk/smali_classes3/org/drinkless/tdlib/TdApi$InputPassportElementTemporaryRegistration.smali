.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementTemporaryRegistration;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementTemporaryRegistration"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7209b21f


# instance fields
.field public temporaryRegistration:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15126
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15127
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;)V
    .locals 0
    .param p1, "inputPersonalDocument"    # Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 15117
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15118
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementTemporaryRegistration;->temporaryRegistration:Lorg/drinkless/tdlib/TdApi$InputPersonalDocument;

    .line 15119
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15123
    const v0, -0x7209b21f

    return v0
.end method
