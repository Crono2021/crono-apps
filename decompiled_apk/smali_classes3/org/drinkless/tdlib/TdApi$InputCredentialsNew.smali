.class public Lorg/drinkless/tdlib/TdApi$InputCredentialsNew;
.super Lorg/drinkless/tdlib/TdApi$InputCredentials;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputCredentialsNew"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x31740ed6


# instance fields
.field public allowSave:Z

.field public data:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27264
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputCredentials;-><init>()V

    .line 27265
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 27254
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputCredentials;-><init>()V

    .line 27255
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputCredentialsNew;->data:Ljava/lang/String;

    .line 27256
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$InputCredentialsNew;->allowSave:Z

    .line 27257
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27261
    const v0, -0x31740ed6

    return v0
.end method
