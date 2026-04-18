.class public Lorg/drinkless/tdlib/TdApi$GroupCallInfo;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupCallInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3533a0d4


# instance fields
.field public groupCallId:I

.field public joinPayload:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 26984
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26985
    return-void
.end method

.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "str"    # Ljava/lang/String;

    .line 26974
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 26975
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$GroupCallInfo;->groupCallId:I

    .line 26976
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GroupCallInfo;->joinPayload:Ljava/lang/String;

    .line 26977
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 26981
    const v0, 0x3533a0d4

    return v0
.end method
