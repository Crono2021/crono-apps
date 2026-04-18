.class public Lorg/drinkless/tdlib/TdApi$FoundUsers;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "FoundUsers"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x44944e5b


# instance fields
.field public nextOffset:Ljava/lang/String;

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25644
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25645
    return-void
.end method

.method public constructor <init>([JLjava/lang/String;)V
    .locals 0
    .param p1, "jArr"    # [J
    .param p2, "str"    # Ljava/lang/String;

    .line 25634
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 25635
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$FoundUsers;->userIds:[J

    .line 25636
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$FoundUsers;->nextOffset:Ljava/lang/String;

    .line 25637
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25641
    const v0, 0x44944e5b

    return v0
.end method
