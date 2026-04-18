.class public Lorg/drinkless/tdlib/TdApi$CallId;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallId"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3eac609


# instance fields
.field public id:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 9276
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9277
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 9267
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 9268
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$CallId;->id:I

    .line 9269
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 9273
    const v0, 0x3eac609

    return v0
.end method
