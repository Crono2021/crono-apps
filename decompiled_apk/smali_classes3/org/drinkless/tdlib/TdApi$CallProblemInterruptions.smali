.class public Lorg/drinkless/tdlib/TdApi$CallProblemInterruptions;
.super Lorg/drinkless/tdlib/TdApi$CallProblem;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CallProblemInterruptions"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x42ba1c62


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 682
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$CallProblem;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 687
    const v0, 0x42ba1c62

    return v0
.end method
