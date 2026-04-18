.class public Lorg/drinkless/tdlib/TdApi$DeleteAllCallMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteAllCallMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x57682e0d


# instance fields
.field public revoke:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11202
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11203
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 11193
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11194
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteAllCallMessages;->revoke:Z

    .line 11195
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11199
    const v0, -0x57682e0d

    return v0
.end method
