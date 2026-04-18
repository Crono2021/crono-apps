.class public Lorg/drinkless/tdlib/TdApi$ChatPosition;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatPosition"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x251b78ab


# instance fields
.field public isPinned:Z

.field public list:Lorg/drinkless/tdlib/TdApi$ChatList;

.field public order:J

.field public source:Lorg/drinkless/tdlib/TdApi$ChatSource;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42798
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42799
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatList;JZLorg/drinkless/tdlib/TdApi$ChatSource;)V
    .locals 0
    .param p1, "chatList"    # Lorg/drinkless/tdlib/TdApi$ChatList;
    .param p2, "j5"    # J
    .param p4, "z8"    # Z
    .param p5, "chatSource"    # Lorg/drinkless/tdlib/TdApi$ChatSource;

    .line 42786
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 42787
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatPosition;->list:Lorg/drinkless/tdlib/TdApi$ChatList;

    .line 42788
    iput-wide p2, p0, Lorg/drinkless/tdlib/TdApi$ChatPosition;->order:J

    .line 42789
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$ChatPosition;->isPinned:Z

    .line 42790
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ChatPosition;->source:Lorg/drinkless/tdlib/TdApi$ChatSource;

    .line 42791
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42795
    const v0, -0x251b78ab

    return v0
.end method
