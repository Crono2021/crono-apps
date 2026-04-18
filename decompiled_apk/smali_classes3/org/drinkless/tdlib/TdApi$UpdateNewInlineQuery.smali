.class public Lorg/drinkless/tdlib/TdApi$UpdateNewInlineQuery;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewInlineQuery"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7171bf34


# instance fields
.field public chatType:Lorg/drinkless/tdlib/TdApi$ChatType;

.field public id:J

.field public offset:Ljava/lang/String;

.field public query:Ljava/lang/String;

.field public senderUserId:J

.field public userLocation:Lorg/drinkless/tdlib/TdApi$Location;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 50990
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50991
    return-void
.end method

.method public constructor <init>(JJLorg/drinkless/tdlib/TdApi$Location;Lorg/drinkless/tdlib/TdApi$ChatType;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "location"    # Lorg/drinkless/tdlib/TdApi$Location;
    .param p6, "chatType"    # Lorg/drinkless/tdlib/TdApi$ChatType;
    .param p7, "str"    # Ljava/lang/String;
    .param p8, "str2"    # Ljava/lang/String;

    .line 50976
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 50977
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineQuery;->id:J

    .line 50978
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineQuery;->senderUserId:J

    .line 50979
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineQuery;->userLocation:Lorg/drinkless/tdlib/TdApi$Location;

    .line 50980
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineQuery;->chatType:Lorg/drinkless/tdlib/TdApi$ChatType;

    .line 50981
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineQuery;->query:Ljava/lang/String;

    .line 50982
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewInlineQuery;->offset:Ljava/lang/String;

    .line 50983
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 50987
    const v0, 0x7171bf34

    return v0
.end method
