.class public Lorg/drinkless/tdlib/TdApi$GroupCallVideoSourceGroup;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GroupCallVideoSourceGroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x46fbb431


# instance fields
.field public semantics:Ljava/lang/String;

.field public sourceIds:[I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27044
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27045
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;[I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "iArr"    # [I

    .line 27034
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27035
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$GroupCallVideoSourceGroup;->semantics:Ljava/lang/String;

    .line 27036
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$GroupCallVideoSourceGroup;->sourceIds:[I

    .line 27037
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27041
    const v0, -0x46fbb431

    return v0
.end method
