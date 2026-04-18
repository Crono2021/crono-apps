.class public Lorg/drinkless/tdlib/TdApi$UpdateBasicGroupFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateBasicGroupFullInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x52f66bbf


# instance fields
.field public basicGroupFullInfo:Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;

.field public basicGroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33808
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33809
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "basicGroupFullInfo"    # Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;

    .line 33798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 33799
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateBasicGroupFullInfo;->basicGroupId:J

    .line 33800
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateBasicGroupFullInfo;->basicGroupFullInfo:Lorg/drinkless/tdlib/TdApi$BasicGroupFullInfo;

    .line 33801
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33805
    const v0, 0x52f66bbf

    return v0
.end method
