.class public Lorg/drinkless/tdlib/TdApi$DeleteBusinessStory;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeleteBusinessStory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3d11ed52


# instance fields
.field public businessConnectionId:Ljava/lang/String;

.field public storyId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24944
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24945
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "i9"    # I

    .line 24934
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 24935
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeleteBusinessStory;->businessConnectionId:Ljava/lang/String;

    .line 24936
    iput p2, p0, Lorg/drinkless/tdlib/TdApi$DeleteBusinessStory;->storyId:I

    .line 24937
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24941
    const v0, 0x3d11ed52

    return v0
.end method
