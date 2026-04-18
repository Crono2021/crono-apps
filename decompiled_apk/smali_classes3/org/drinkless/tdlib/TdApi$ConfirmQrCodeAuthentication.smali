.class public Lorg/drinkless/tdlib/TdApi$ConfirmQrCodeAuthentication;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ConfirmQrCodeAuthentication"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Session;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x166c58d3


# instance fields
.field public link:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10968
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10969
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 10959
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10960
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ConfirmQrCodeAuthentication;->link:Ljava/lang/String;

    .line 10961
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10965
    const v0, -0x166c58d3

    return v0
.end method
