.class public Lorg/drinkless/tdlib/TdApi$GetMe;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetMe"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$User;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xb6a4d81


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2479
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 2484
    const v0, -0xb6a4d81

    return v0
.end method
