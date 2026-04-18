.class public Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResultText;
.super Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SpeechRecognitionResultText"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7f197e23


# instance fields
.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20022
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;-><init>()V

    .line 20023
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20013
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResult;-><init>()V

    .line 20014
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SpeechRecognitionResultText;->text:Ljava/lang/String;

    .line 20015
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20019
    const v0, -0x7f197e23

    return v0
.end method
