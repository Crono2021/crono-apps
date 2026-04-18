.class public Lorg/drinkless/tdlib/TdApi$CallProblemSilentLocal;
.super Lorg/drinkless/tdlib/TdApi$CallProblem;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallProblemSilentLocal"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xf1e6f36


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 712
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallProblem;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 717
    const v0, 0xf1e6f36

    return v0
.end method
