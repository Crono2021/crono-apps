.class public Lorg/drinkless/tdlib/TdApi$SendWebAppCustomRequest;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SendWebAppCustomRequest"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$CustomRequestResult;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x36ff5dc8


# instance fields
.field public botUserId:J

.field public method:Ljava/lang/String;

.field public parameters:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40020
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40021
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "str2"    # Ljava/lang/String;

    .line 40009
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 40010
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$SendWebAppCustomRequest;->botUserId:J

    .line 40011
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$SendWebAppCustomRequest;->method:Ljava/lang/String;

    .line 40012
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$SendWebAppCustomRequest;->parameters:Ljava/lang/String;

    .line 40013
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 40017
    const v0, 0x36ff5dc8

    return v0
.end method
