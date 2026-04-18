.class public Lorg/drinkless/tdlib/TdApi$CreateGroupCall;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateGroupCall"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$GroupCallInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x730a82c0


# instance fields
.field public joinParameters:Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11095
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;)V
    .locals 0
    .param p1, "groupCallJoinParameters"    # Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;

    .line 11085
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 11086
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$CreateGroupCall;->joinParameters:Lorg/drinkless/tdlib/TdApi$GroupCallJoinParameters;

    .line 11087
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11091
    const v0, 0x730a82c0

    return v0
.end method
