.class public Lorg/drinkless/tdlib/TdApi$UpdateFreezeState;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateFreezeState"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x64e022ac


# instance fields
.field public appealLink:Ljava/lang/String;

.field public deletionDate:I

.field public freezingDate:I

.field public isFrozen:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46086
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46087
    return-void
.end method

.method public constructor <init>(ZIILjava/lang/String;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "i9"    # I
    .param p3, "i10"    # I
    .param p4, "str"    # Ljava/lang/String;

    .line 46074
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46075
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateFreezeState;->isFrozen:Z

    .line 46076
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$UpdateFreezeState;->freezingDate:I

    .line 46077
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateFreezeState;->deletionDate:I

    .line 46078
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UpdateFreezeState;->appealLink:Ljava/lang/String;

    .line 46079
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46083
    const v0, 0x64e022ac

    return v0
.end method
