.class public Lorg/drinkless/tdlib/TdApi$CreateBasicGroupChat;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateBasicGroupChat"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Chat;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x758ab4e4


# instance fields
.field public basicGroupId:J

.field public force:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24664
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24665
    return-void
.end method

.method public constructor <init>(JZ)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "z8"    # Z

    .line 24654
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24655
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateBasicGroupChat;->basicGroupId:J

    .line 24656
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$CreateBasicGroupChat;->force:Z

    .line 24657
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24661
    const v0, 0x758ab4e4

    return v0
.end method
