.class public Lorg/drinkless/tdlib/TdApi$GetBasicGroup;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetBasicGroup"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BasicGroup;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6176c9ac


# instance fields
.field public basicGroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 12084
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12085
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 12075
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 12076
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetBasicGroup;->basicGroupId:J

    .line 12077
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 12081
    const v0, -0x6176c9ac

    return v0
.end method
