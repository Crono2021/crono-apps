.class public Lorg/drinkless/tdlib/TdApi$CreatedBasicGroupChat;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreatedBasicGroupChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1378a2c


# instance fields
.field public chatId:J

.field public failedToAddMembers:Lorg/drinkless/tdlib/TdApi$FailedToAddMembers;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24764
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24765
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$FailedToAddMembers;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "failedToAddMembers"    # Lorg/drinkless/tdlib/TdApi$FailedToAddMembers;

    .line 24754
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 24755
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreatedBasicGroupChat;->chatId:J

    .line 24756
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreatedBasicGroupChat;->failedToAddMembers:Lorg/drinkless/tdlib/TdApi$FailedToAddMembers;

    .line 24757
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24761
    const v0, -0x1378a2c

    return v0
.end method
