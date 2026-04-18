.class public Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UnconfirmedSession"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x7af2b607


# instance fields
.field public deviceModel:Ljava/lang/String;

.field public id:J

.field public location:Ljava/lang/String;

.field public logInDate:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 45966
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45967
    return-void
.end method

.method public constructor <init>(JILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "str"    # Ljava/lang/String;
    .param p5, "str2"    # Ljava/lang/String;

    .line 45954
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 45955
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;->id:J

    .line 45956
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;->logInDate:I

    .line 45957
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;->deviceModel:Ljava/lang/String;

    .line 45958
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UnconfirmedSession;->location:Ljava/lang/String;

    .line 45959
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 45963
    const v0, -0x7af2b607

    return v0
.end method
